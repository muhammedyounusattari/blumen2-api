package com.kastech.blumen.service.users;

import com.kastech.blumen.model.Configurations.GenerateResponse;
import com.kastech.blumen.model.users.AccessType;
import com.kastech.blumen.model.users.Priviledges;
import com.kastech.blumen.model.users.PriviledgeResponse;
import com.kastech.blumen.model.users.UserPriviledges;
import com.kastech.blumen.repository.users.PriviledgesRepository;
import com.kastech.blumen.repository.users.UserPriviledgesRepository;
import com.kastech.blumen.repository.users.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServices {

    @Autowired
    private UserRolesRepository userRolesRepository;

    @Autowired
    private UserPriviledgesRepository userPriviledgesRepository;

    @Autowired
    private PriviledgesRepository priviledgesRepository;

    public List<Priviledges> getPriviledgeLists()
    {
        Integer ErrorCode = 0 ;
        long roleId=0;
        String Message = "Success";
        List<Priviledges> priviledges = priviledgesRepository.findAllByParentId(roleId);
        return priviledges;
    }

    public GenerateResponse getPriviledgeListByRoleId(long roleId)
    {
        Integer ErrorCode = 0 ;
        String Message = "Success";
        List<Priviledges> priviledges = priviledgesRepository.findAllByParentId(roleId);
        //List<PriviledgeResponse> priviledges = generateListByRoleId((long)0, roleId, userPriviledges);

        return new GenerateResponse(ErrorCode, Message, priviledges);
    }

    private List<PriviledgeResponse> generateList(Long parentId)
    {
        List<Priviledges> priviledges = priviledgesRepository.findAllByParentId(parentId);
        List<PriviledgeResponse> priviledgeResponse = new List<PriviledgeResponse>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<PriviledgeResponse> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(PriviledgeResponse priviledgeResponse) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends PriviledgeResponse> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends PriviledgeResponse> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public PriviledgeResponse get(int index) {
                return null;
            }

            @Override
            public PriviledgeResponse set(int index, PriviledgeResponse element) {
                return null;
            }

            @Override
            public void add(int index, PriviledgeResponse element) {

            }

            @Override
            public PriviledgeResponse remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<PriviledgeResponse> listIterator() {
                return null;
            }

            @Override
            public ListIterator<PriviledgeResponse> listIterator(int index) {
                return null;
            }

            @Override
            public List<PriviledgeResponse> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for (final Priviledges Priviledge : priviledges) {
            PriviledgeResponse responseItem = new PriviledgeResponse();
            responseItem.setPriviledgesId(Priviledge.getId());
//            responseItem.setIsAccess(Priviledge.getIsAccess());
            responseItem.setPriviledgesParentId(Priviledge.getPriviledgesParentId());
            responseItem.setPriviledgeName(Priviledge.getPriviledgeName());
            responseItem.setPriviledgesList( this.generateList(Priviledge.getId()));
            priviledgeResponse.add(responseItem);
        }
        return priviledgeResponse;
    }


    private List<PriviledgeResponse> generateListByRoleId(Long parentId, Long RoleId, List<UserPriviledges> userPriviledges)
    {
        List<Priviledges> priviledges = priviledgesRepository.findAllByParentId(parentId);
        List<PriviledgeResponse> priviledgeResponse = new List<PriviledgeResponse>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<PriviledgeResponse> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(PriviledgeResponse priviledgeResponse) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends PriviledgeResponse> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends PriviledgeResponse> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public PriviledgeResponse get(int index) {
                return null;
            }

            @Override
            public PriviledgeResponse set(int index, PriviledgeResponse element) {
                return null;
            }

            @Override
            public void add(int index, PriviledgeResponse element) {

            }

            @Override
            public PriviledgeResponse remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<PriviledgeResponse> listIterator() {
                return null;
            }

            @Override
            public ListIterator<PriviledgeResponse> listIterator(int index) {
                return null;
            }

            @Override
            public List<PriviledgeResponse> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        for (final Priviledges Priviledge : priviledges) {
            PriviledgeResponse responseItem = new PriviledgeResponse();
            responseItem.setPriviledgesId(Priviledge.getId());
            responseItem.setIsAccess(validateAccess(Priviledge.getId(), userPriviledges));
            responseItem.setPriviledgesParentId(Priviledge.getPriviledgesParentId());
            responseItem.setPriviledgeName(Priviledge.getPriviledgeName());
            responseItem.setPriviledgesList( this.generateList(Priviledge.getId()));
            priviledgeResponse.add(responseItem);
        }
        return priviledgeResponse;
    }

    private AccessType validateAccess(long PriviledgesId, List<UserPriviledges> userPriviledges)
    {
        Iterator<UserPriviledges> iterator = userPriviledges.iterator();
        while (iterator.hasNext()) {
            UserPriviledges priviledge = iterator.next();
            if (priviledge.getPriviledgesId() == PriviledgesId) {
                return priviledge.getIsAccess();
            }
        }
        return AccessType.FALSE;
    }
}
