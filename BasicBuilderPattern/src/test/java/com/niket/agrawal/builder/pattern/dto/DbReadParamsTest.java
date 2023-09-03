package com.niket.agrawal.builder.pattern.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DbReadParamsTest {

    @Test
    void testOnlyWhereClause() {
        DbReadParams dbReadParam = new DbReadParams.Builder().setWhereClause("User Where Clause")
            .build();
        assertEquals("User Where Clause", dbReadParam.getWhereClause());
    }

    @Test
    void testWhereWithSelectClause() {
        DbReadParams dbReadParam = new DbReadParams.Builder().setWhereClause("User Where Clause")
            .setSelectClause("Select Fields")
            .build();
        assertEquals("User Where Clause", dbReadParam.getWhereClause());
        assertEquals("Select Fields", dbReadParam.getSelectClause());
    }

    @Test
    void testWhereWithOrderByClause() {
        DbReadParams dbReadParam = new DbReadParams.Builder().setWhereClause("User Where Clause")
            .setOrderByClause("order by desc")
            .build();
        assertEquals("User Where Clause", dbReadParam.getWhereClause());
        assertEquals("order by desc", dbReadParam.getOrderByClause());
    }

    @Test
    void testAllParams() {
        DbReadParams dbReadParam = new DbReadParams.Builder().setWhereClause("User Where Clause")
            .setOrderByClause("order by desc")
            .setSelectClause("Select Fields")
            .setGroupByClause("GroupBy Fields")
            .build();
        assertEquals("User Where Clause", dbReadParam.getWhereClause());
        assertEquals("order by desc", dbReadParam.getOrderByClause());
        assertEquals("Select Fields", dbReadParam.getSelectClause());
        assertEquals("GroupBy Fields", dbReadParam.getGroupByClause());
    }

    @Test
    void testFieldValidation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new DbReadParams.Builder().build();
        });
        assertEquals("Where Clause is Mandatory", exception.getMessage());
    }

}
