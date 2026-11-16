package com.assetflow.service;

import com.assetflow.entity.Employee;
import com.assetflow.exception.ResourceNotFoundException;
import com.assetflow.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service @RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    public List<Employee> all() { return repository.findAll(); }
    public Employee one(Long id) { return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found: " + id)); }
    public Employee save(Employee employee) { return repository.save(employee); }
    public void delete(Long id) { repository.delete(one(id)); }
}
