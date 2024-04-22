@PEI @Objetivos_Estrategiso
Feature: En el modulo de AppBuilder deseo tener automatizado los procesos de PEI donde se realiza el planeamiento
        del PEI (Plan Estrategico Inicial)

  Background:
    Given Inicio sesión en AppBuilder Desarrollo
    Given Ingreso al modulo SISCO
    And Selecciono el rol Usuario PSC e ingreso al sistema

  @PEI @CP001
  Scenario Outline: CP001 - Creacion de Objetivo Estrategico
    And Ingreso al menú de Objetivos Estrategicos
    And Selecciono Nuevo registro
    When Completo el formulario de Objetivos Estrategicos "<enunciado>", "<descripcion>", "<explicacion>"
    Then Se muestra mensaje de registro exitoso
    Examples:
      | enunciado                     | descripcion                       | explicacion                     |
      | A ENUNCIADO AUTOMATION JJP    | A DESCRIPCION AUTOMATION JJP      | A EXPLICACION AUTOMATION JJP    |

  @PEI @CP002
  Scenario Outline: CP002 - Editar registro de Objetivo Estrategico
    And Ingreso al menú de Objetivos Estrategicos
    And Ubicar registro y presionar icono Editar
    When Edito el formulario de Objetivos Estrategicos "<codigo>", "<enunciado>", "<descripcion>", "<explicacion>", "<accionesEst>"
    Then Se muestra mensaje de edicion exitosa
    Examples:
    | codigo    | enunciado                      | descripcion                      | explicacion                      | accionesEst |
    | OEI.15    | A ENUNCIADO AUTOMATION EDITADO | A DESCRIPCION AUTOMATION EDITADO | A EXPLICACION AUTOMATION EDITADO | 9           |

  @PEI @CP003
  Scenario: CP003 - Eliminar registro de Objetivo Estrategico
    And Ingreso al menú de Objetivos Estrategicos
    And Ubicar registro y presionar icono Eliminar
    And Confirmo la eliminacion presionando SI
    Then Se muestra mensaje de eliminacion exitosa

  @PEI @CP004
  Scenario Outline: CP004 - Creacion de Acción Estrategica
    And Ingresar Menu Acciones Estrategicas
    And Seleccionar Nueva Accion Estrategica
    When Completar formulario de Acciones Estrategicas "<enunciado>", "<descripcion>", "<explicacion>"
    Then Muestra mensaje Accion Estrategica creada
    Examples:
      | enunciado                     | descripcion                       | explicacion                     |
      | A ENUNCIADO AUTOMATION JJP    | A DESCRIPCION AUTOMATION JJP      | A EXPLICACION AUTOMATION JJP    |