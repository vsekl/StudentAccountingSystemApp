package ru.vsevakl.accounting.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private String firstname;
    private String lastname;
    private Long age;
    private SortRequest sortRequest;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SortRequest {
        private Sort sort;
        private SortParam sortParam;
    }

    public enum Sort {
        ASC,
        DESC,
    }

    public enum SortParam {
        firstname,
        lastname,
        age
    }
}
