package com.kastech.blumen.model.student;


public class PageableDto {
    private int pageNumber;

    private int recordsPerPage;

    private String sortingOrder;

    private String sortingFieldName;

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getRecordsPerPage() {
        if(recordsPerPage ==0){
            recordsPerPage =10;
        }
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public String getSortingOrder() {
        return sortingOrder;
    }

    public void setSortingOrder(String sortingOrder) {
        this.sortingOrder = sortingOrder;
    }

    public String getSortingFieldName() {
        return sortingFieldName;
    }

    public void setSortingFieldName(String sortingFieldName) {
        this.sortingFieldName = sortingFieldName;
    }
}
