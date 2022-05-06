package gt1000.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse<T> {

    private final int status;
    private final T payload;
    private final Paging paging;
    private final String errorMessage;

    @Builder
    public ResultResponse(int status, T payload, Paging paging, String errorMessage) {
        this.status = status;
        this.payload = payload;
        this.paging = paging;
        this.errorMessage = errorMessage;
    }

    public static <T> ResultResponse<List<T>> withPage(Page<T> page, HttpStatus status, String message) {
        Paging paging = Paging.builder()
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .pageNumber(page.getNumber())
                .size(page.getSize())
                .first(page.isFirst())
                .last(page.isLast())
                .build();

        return ResultResponse.<List<T>>builder()
                .status(status.value())
                .payload(page.getContent())
                .paging(paging)
                .build();
    }

    public static <T> Paging createPaging(Page<T> page) {
        return Paging.builder()
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .pageNumber(page.getNumber())
                .size(page.getSize())
                .first(page.isFirst())
                .last(page.isLast())
                .build();
    }

    @Getter
    @Builder
    static class Paging {
        private final long totalElements; // 총 데이터 수
        private final int totalPages; // 총 페이지 수
        private final int pageNumber; // 현재 페이지 번호
        private final int size; //현재 페이지 데이터 수
        private final boolean first; // 첫 페이지 여부
        private final boolean last; // 마지막 페이지 여부
    }
}