package com.payroll.gatosrest.configuration;

public class CattoNotFoundException extends RuntimeException {
    public CattoNotFoundException(Long id) {
        super("Could not found Mr Catto " + id);
    }
}
