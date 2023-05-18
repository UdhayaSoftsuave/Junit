package com.example.JuintTesting.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class SalaryEntity implements EmployeeHeader{

    private int id;

    private int amount;

    private int pfAmount;

    private Integer employeeId;

    @Override
    public void setEmployeeId(Integer id) {
        this.employeeId = id;
    }
}
