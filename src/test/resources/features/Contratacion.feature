Feature: Contratacion

  Scenario: Flujo de de contratacion
    Given El usuario inicia sesion
    When El cliente realiza proceso de contratacion
    Then El usuario valida que los datos de la persona correspondan a los diligenciados
      | Vacante               | Candidato             | Fecha      | Estado |
      | Payroll Administrator | Brayan Miguel Sanchez | 2024-12-07 | Hired  |
