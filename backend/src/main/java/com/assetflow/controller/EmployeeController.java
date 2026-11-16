package com.assetflow.controller;
import com.assetflow.entity.Employee;
import com.assetflow.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/employees") @RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService service;
    @GetMapping public List<Employee> all() { return service.all(); }
    @GetMapping("/{id}") public Employee one(@PathVariable Long id) { return service.one(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Employee create(@Valid @RequestBody Employee employee) { return service.save(employee); }
    @PutMapping("/{id}") public Employee update(@PathVariable Long id, @RequestBody Employee employee) { employee.setId(id); return service.save(employee); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
