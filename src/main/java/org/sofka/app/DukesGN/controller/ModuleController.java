package org.sofka.app.DukesGN.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.sofka.app.DukesGN.dto.ModuleDto;
import org.sofka.app.DukesGN.service.implementation.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

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

    @Operation(summary = " --> Endpoint que nos permite crear un modulo")
    @ApiResponse(responseCode = "200", description = "Se creo el modulo")
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

    @Operation(summary = " --> Endpoint que nos permite obtener un modulo por id")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el modulo por id")
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

    @Operation(summary = " --> Endpoint que nos permite listar todos los modulos")
    @ApiResponse(responseCode = "200", description = "Se listaron los modulos")
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

    @Operation(summary = " --> Endpoint que nos permite actualizar un modulo por id")
    @ApiResponse(responseCode = "200", description = "Se actualizo el modulo ")
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

    @Operation(summary = " --> Endpoint que nos permite eliminar un modulo por id")
    @ApiResponse(responseCode = "200", description = "Se elimino el modulo por id")
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

    /**
     * Endpoint para guardar una lista de modules
     *
     * @return Mono<ResponseEntity < Flux < List < ModuleDto>>>>
     */

    @Operation(summary = " --> Endpoint que nos permite guardar una lista de modulos")
    @ApiResponse(responseCode = "200", description = "Se guardo la lista de modulos")
    @PostMapping("/saveAll")
    public Mono<ResponseEntity<Flux<List<ModuleDto>>>> saveAllModule(@RequestBody List<ModuleDto> list) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.saveAllModule(list))

            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la lista de module");

        }

    }


    /**
     * Endpoint para listar modules por id
     *
     * @param id_course
     * @return Mono<ResponseEntity < Flux < ModuleDto>>>
     */

    @Operation(summary = " --> Endpoint que nos permite obtener un modulo por id del curso")
    @ApiResponse(responseCode = "200", description = "Se obtuvo el modulo por id del curso")
    @GetMapping("/course/{id_course}")
    public Mono<ResponseEntity<Flux<ModuleDto>>> getModulesByIdCurso(@PathVariable("id_course") String id_course) {
        try {
            return Mono.just(
                    ResponseEntity
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(moduleService.listModules()
                                    .filter(moduleDto -> Objects.equals(moduleDto.getId_course(), id_course)))
            );
        } catch (Exception e) {
            throw new RuntimeException("No se pudo lsitar los modulos por el id del curso");
        }

    }

}
