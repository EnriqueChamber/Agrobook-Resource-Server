Feature: Gestion de usuarios

   Scenario: el usuario recupera su propia informacion
     Given un usuario que inicio sesion con el nombre de usuario "usuario123"
     When el usuario solicita su propia informacion de usuario
     Then el sistema deberia devolver los detalles del usuario para "usuario123"

   Scenario: el usuario actualiza su propia informacion
     Given un usuario que inicio sesion con el nombre de usuario "usuario123"
     When el usuario actualiza su propia informacion con nuevos detalles
     Then el sistema deberia actualizar la informacion del usuario para "usuario123"

   Scenario: el usuario crea una nueva cuenta
     Given que un usuario quiere crear una nueva cuenta
     When el usuario proporciona datos de registro validos
     Then el sistema deberia crear una nueva cuenta de usuario con los detalles proporcionados.

   Scenario: el usuario actualiza la informacion de otro usuario (administrador)
     Given un usuario administrador con nombre de usuario "admin123"
     And existe un usuario con el nombre de usuario "usuario456"
     When el usuario administrador actualiza la informacion del usuario "user456" con nuevos detalles
     Then el sistema deberia actualizar la informacion del usuario para "user456"

   Scenario: el usuario intenta actualizar la informacion de otro usuario (no administrador)
     Given un usuario normal con nombre de usuario "usuario123"
     And existe un usuario con el nombre de usuario "usuario456"
     When el usuario normal intenta actualizar la informacion del usuario "user456"
     Then el sistema deberia negar la operacion de actualizacion debido a permisos insuficientes.

   Scenario: el usuario recupera la informacion de otro usuario
     Given un usuario que inicio sesion con el nombre de usuario "usuario123"
     And existe un usuario con el nombre de usuario "usuario456"
     When el usuario solicita la informacion para el usuario "user456"
     Then el sistema deberia devolver los detalles del usuario para "user456"

   Scenario: el usuario recupera informacion de un usuario no existente
     Given un usuario que inicio sesion con el nombre de usuario "usuario123"
     When el usuario solicita la informacion para un usuario no existente
     Then el sistema deberia devolver un mensaje indicando que el usuario no existe