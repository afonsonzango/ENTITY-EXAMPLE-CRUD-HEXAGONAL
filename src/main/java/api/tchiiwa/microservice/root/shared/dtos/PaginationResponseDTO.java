package api.tchiiwa.microservice.root.shared.dtos;

public class PaginationResponseDTO {
    private long allItems;
    private long totalItems;
    private int totalPages;
    private int totalCurrentItems;
    private int currentPage;
    private Integer nextPage;

    public PaginationResponseDTO() {
    }

    public PaginationResponseDTO(long allItems, long totalItems, int totalPages, int totalCurrentItems, int currentPage, Integer nextPage) {
        this.allItems = allItems;
        this.totalItems = totalItems;
        this.totalPages = totalPages;
        this.totalCurrentItems = totalCurrentItems;
        this.currentPage = currentPage;
        this.nextPage = nextPage;
    }

    public long getAllItems() {
        return allItems;
    }

    public void setAllItems(long allItems) {
        this.allItems = allItems;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalCurrentItems() {
        return totalCurrentItems;
    }

    public void setTotalCurrentItems(int totalCurrentItems) {
        this.totalCurrentItems = totalCurrentItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }
}
