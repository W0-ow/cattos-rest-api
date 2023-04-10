package com.payroll.gatosrest.configuration;

public class GatoNotFoundException extends RuntimeException
{
    public GatoNotFoundException(Long id) {
        super("Could not found Catto" + id);
    }
}
