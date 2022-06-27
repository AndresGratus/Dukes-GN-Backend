package org.sofka.app.DukesGN.controller;


import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.service.implementation.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/module")
public class ModuleController {

    /**
     * Se inyecta el servicio de module
     */
    @Autowired
    private ModuleService moduleService;

    /**
     * Endpoint para crear un module
     *
     * @param moduleDto
     * @return Mono<ResponseEntity < Mono < ModuleDto>>>
     */
    @PostMapping("/create")
    public Mono<ResponseEntity<Mono<ModuleDto>>> createModule(@RequestBody ModuleDto moduleDto) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.createModule(moduleDto))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crea el module");
        }
    }

    /**
     * Endpoint para obtener un module por id
     *
     * @param module_id
     * @return Mono<ResponseEntity < Mono < ModuleDto>>>
     */
    @GetMapping("/get/{module_id}")
    public Mono<ResponseEntity<Mono<ModuleDto>>> getModuleById(@PathVariable("module_id") String module_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.getModule(module_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se puede obtener el modulo por id");
        }
    }

    /**
     * Endpoint para listar los modulos
     *
     * @return Mono<ResponseEntity < Flux < ModuleDto>>>
     */

    @GetMapping("/list")
    public Mono<ResponseEntity<Flux<ModuleDto>>> listAllModule() {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.listModules())
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo listar los modulos");
        }
    }

    /**
     * Endpoint para actualizar un modulo
     *
     * @param moduleDto
     * @param module_id
     * @return Mono<ResponseEntity < Mono < ModuleDto>>
     */

    @PutMapping("/update/{module_id}")
    public Mono<ResponseEntity<Mono<ModuleDto>>> updateModule(@RequestBody ModuleDto moduleDto, @PathVariable("module_id") String module_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.updateModule(module_id, moduleDto))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo actualizar el modulo");
        }
    }

    /**
     * Endpoint para eliminar un modulo por id
     *
     * @param module_id
     * @return Mono<ResponseEntity < Mono < Void>>>
     */

    @DeleteMapping("/delete/{module_id}")
    public Mono<ResponseEntity<Mono<Void>>> deleteModuloById(@PathVariable("module_id") String module_id) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .body(moduleService.deleteModule(module_id))
            );
        } catch (Exception e) {
            throw new RuntimeException("Se pudo eliminar el modulo");
        }

    }

}
