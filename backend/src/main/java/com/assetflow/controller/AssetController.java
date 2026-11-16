package com.assetflow.controller;
import com.assetflow.entity.Asset;
import com.assetflow.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/assets") @RequiredArgsConstructor
public class AssetController {
    private final AssetService service;
    @GetMapping public List<Asset> all() { return service.all(); }
    @GetMapping("/available") public List<Asset> available() { return service.available(); }
    @GetMapping("/{id}") public Asset one(@PathVariable Long id) { return service.one(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) public Asset create(@RequestBody Asset asset) { return service.save(asset); }
    @PutMapping("/{id}") public Asset update(@PathVariable Long id, @RequestBody Asset asset) { asset.setId(id); return service.save(asset); }
    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id) { service.delete(id); }
}
