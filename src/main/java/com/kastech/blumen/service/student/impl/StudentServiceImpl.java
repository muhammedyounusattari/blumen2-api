package com.kastech.blumen.service.student.impl;

import com.kastech.blumen.controller.response.StudentSaveResponse;
import com.kastech.blumen.exception.ServiceLayerException;
import com.kastech.blumen.model.student.*;
import com.kastech.blumen.repository.student.StudentFilterView;
import com.kastech.blumen.model.student.Student;
import com.kastech.blumen.model.student.StudentDataObject;
import com.kastech.blumen.model.student.StudentYearlyData;
import com.kastech.blumen.repository.student.StudentRepository;
import com.kastech.blumen.repository.student.StudentYearlyDataRepository;
import com.kastech.blumen.service.student.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

@Service
public class StudentServiceImpl implements StudentService {
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static final String ALL = "ALL";

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentYearlyDataRepository studentYearlyDataRepository;

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ServiceLayerException("student not found"));
    }

    public String generateSystemSerialNumber(Integer organizationId) {
        String ssno = "999-00-0001";
        Student student = repository.findFirstByOrganizationIdOrderByStuidDesc(organizationId);
        if (null != student) {
            String existingSsno = student.getSsno();
            String[] splittedArray = existingSsno.split("-");
            int lastValue = parseInt(splittedArray[2]);
            int midValue = parseInt(splittedArray[1]);
            if (lastValue == 9999) {
                lastValue = 1;
                midValue++;
            } else {
                lastValue++;
            }
            ssno = "999-" + format("%02d", midValue) + "-" + format("%04d", lastValue);
        }
        return ssno;
    }

    public StudentSaveResponse addNewStudent(StudentDataObject studentDataObject) {
        Student student = studentDataObject.getStudent();
        StudentSaveResponse studentSaveResponse = new StudentSaveResponse();
        Student existingStudent = repository.findBySsnoAndOrganizationId(student.getSsno(), student.getOrganizationId());
        if(null != existingStudent) {
            studentSaveResponse.setObject(existingStudent);
            studentSaveResponse.setErrorCode("SSNO_ALREADY_EXISTS");
            return studentSaveResponse;
        }
        existingStudent = repository.findBySfirstAndSlastAndOrganizationId(student.getSfirst(), student.getSlast(), student.getOrganizationId());
        if(null != existingStudent) {
            studentSaveResponse.setObject(existingStudent);
            studentSaveResponse.setErrorCode("NAME_ALREADY_EXISTS");
            return studentSaveResponse;
        }
        existingStudent = repository.findBySfirstAndSlastAndOrganizationId(student.getSlast(), student.getSfirst(), student.getOrganizationId());
        if(null != existingStudent) {
            studentSaveResponse.setObject(existingStudent);
            studentSaveResponse.setErrorCode("NAME_ALREADY_EXISTS");
            return studentSaveResponse;
        }
        StudentYearlyData studentYearlyData = studentDataObject.getStudentYearlyData();
        student.setEntryDate(LocalDate.now());
        student = repository.save(student);
        studentYearlyData.setStuid(BigInteger.valueOf(student.getStuid()));
        studentYearlyData = studentYearlyDataRepository.save(studentYearlyData);

        studentDataObject.setStudent(student);
        studentDataObject.setStudentYearlyData(studentYearlyData);
        studentSaveResponse.setObject(studentDataObject);
        return studentSaveResponse;
    }

    public StudentSaveResponse addStudentWithoutValidation(StudentDataObject studentDataObject) {
        StudentSaveResponse studentSaveResponse = new StudentSaveResponse();
        Student student = studentDataObject.getStudent();
        StudentYearlyData studentYearlyData = studentDataObject.getStudentYearlyData();
        student.setEntryDate(LocalDate.now());
        student = repository.save(student);
        studentYearlyData.setStuid(BigInteger.valueOf(student.getStuid()));
        studentYearlyData = studentYearlyDataRepository.save(studentYearlyData);

        studentDataObject.setStudent(student);
        studentDataObject.setStudentYearlyData(studentYearlyData);
        studentSaveResponse.setObject(studentDataObject);
        return studentSaveResponse;
    }

    @Override
    public StudentFilterResponse filterStudents(StudentFilterDto studentFilterDto) {
        if(studentFilterDto.getSortingFieldName()!=null ){
            if(!validateSortingFiled(studentFilterDto.getSortingFieldName())) {
                throw new ServiceLayerException("SortingFieldName is Invalid");
            }
        }
        StudentFilterResponse studentFilterResponse = new StudentFilterResponse();
        List<StudentListDto> studentListDtoList = null;
        Pageable pageable =getPageable(studentFilterDto);
        if(studentFilterDto.getFinancialYear() ==0 ){
            Page<Student> pageStudents = repository.getStudents(pageable);
            List<Student> studentList = pageStudents.getContent();
            if(!Objects.isNull(studentList) && !studentList.isEmpty()){
               studentListDtoList= studentList.stream().map(this::mapToStudentListDto).collect(Collectors.toList());

            }
            studentFilterResponse.setTotalRecords(pageStudents.getTotalElements());
            studentFilterResponse.setTotalNumberOfPages(pageStudents.getTotalPages());
        }
        else{
           Page<StudentFilterView> studentFilterViews = repository.findStudentView(pageable,studentFilterDto.getFinancialYear(),
                   getBoolean(studentFilterDto.getActive() ), studentFilterDto.getActive()==null ||
                           ALL.equalsIgnoreCase(studentFilterDto.getActive()) ? 1 :0 ,
                   getBoolean(studentFilterDto.getReported() ),
                   studentFilterDto.getReported()==null ||
                           ALL.equalsIgnoreCase(studentFilterDto.getReported()) ? 1 :0,getBoolean(studentFilterDto.getServed() ),
                   studentFilterDto.getServed()==null ||
                           ALL.equalsIgnoreCase(studentFilterDto.getServed()) ? 1 :0
                   );
            List<StudentFilterView> studentFilterViewList = studentFilterViews.getContent();
            studentListDtoList= studentFilterViewList.stream().map(this::mapToStudentListDto).collect(Collectors.toList());
            studentFilterResponse.setTotalRecords(studentFilterViews.getTotalElements());
            studentFilterResponse.setTotalNumberOfPages(studentFilterViews.getTotalPages());
        }

        studentFilterResponse.setStudentList(studentListDtoList);
        return studentFilterResponse;
    }
    private Pageable getPageable(PageableDto pageableDto){
        Pageable pageable = null;
        pageable = PageRequest.of(pageableDto.getPageNumber(), pageableDto.getRecordsPerPage());
        if (pageableDto.getSortingFieldName() != null) {
            Sort sort = Sort.by(pageableDto.getSortingFieldName());
            if("descending".equals(pageableDto.getSortingOrder())){
                sort= sort.descending();
            }
            else{
                sort=sort.ascending();
            }
            pageable = PageRequest.of(pageableDto.getPageNumber(), pageableDto.getRecordsPerPage(),sort);
        }
        return pageable;
    }
    private StudentListDto mapToStudentListDto(Student student){
        StudentListDto studentListDto = new StudentListDto();
        BeanUtils.copyProperties(student,studentListDto);
        return studentListDto;
    }

    private StudentListDto mapToStudentListDto(StudentFilterView studentFilterView) {
        StudentListDto studentListDto = new StudentListDto();
        studentListDto.setSfirst(studentFilterView.getSfirst());
        studentListDto.setSlast(studentFilterView.getSlast());
        studentListDto.setPhone1(studentFilterView.getPhone1());
        studentListDto.setPhone2(studentFilterView.getPhone2());
        studentListDto.setYearFi(studentFilterView.getYearFi());
        studentListDto.setActive(studentFilterView.getActive() != null && studentFilterView.getActive() ? YES : NO);
        studentListDto.setReported(studentFilterView.getReported() != null && studentFilterView.getReported() ? YES : NO);
        studentListDto.setServed(studentFilterView.getServed() != null && studentFilterView.getServed() ? YES : NO);
        studentListDto.setSchool(studentFilterView.getSchool());
        studentListDto.setStanding(studentFilterView.getStanding());
        return studentListDto;
    }
    private Boolean getBoolean(String yesOrNoField){
         return yesOrNoField!=null &&YES.equalsIgnoreCase(yesOrNoField) ? Boolean.TRUE: Boolean.FALSE;
    }
    public boolean validateSortingFiled(String sortingFiledName) {
        boolean validField = false;
        Field[] allFields = StudentListDto.class.getDeclaredFields();
        for (Field field : allFields
        ) {
            if (sortingFiledName.equals(field.getName())) {
                validField = true;
                break;
            }

        }
        return validField;
    }

    @Override
    @Transactional
    public void updateStudentProfileImagePath(long id, String imagePath) {
        repository.updateStudentProfileImagePath(id, imagePath);
    }

}
