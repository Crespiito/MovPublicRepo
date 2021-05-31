#language: es

  Característica: yo como usuario deseo crear y eliminar un usuario por medio de servicios

    Escenario: Flujo de eliminacion
      Dado me autentico con las credenciales
      Cuando elimino el usuario creado
      Entonces valido la respuesta exitosa

