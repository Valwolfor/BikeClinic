# BikeClinic
 arquitectura

Los usuarios tiene 3 roles admin, mechanic and assistant cada uno con ciertos permisos
Se usan enumeradores para cada uno de los roles. También puede tener un estado Active o inactive.
Falta hacer manejo de excepciones en caso de null
Se puede mejorar las repuesta con Http y la gestión ante fallos.
Validaciones cono notnul y tamaños y valid para el rest. 

**Datos registrados por postman**

Customer.id=306
Customer.email=nuevoemail@example.com

User.admin.id=309
User.admin.email=admin@example.com
User.admin.password=admin

User.mechanic.id=311
User.mechanic.email=mechanic@example.com
User.mechanic.password=mecha

Motorcycle.id=101
Motorcycle.chassisId=C345
Motorcycle.engineId=E345
Motorcycle.plate=MNO346

Product.id=23

Service.id=14

Status.id=66

ServiceOrder.id=30

Record.id=4

Sistema de facturación, sistema de invetariado, validación de estado de usuario
control de registro con cliente y moto, validación de expresión regurar para placa.
o el Validador
En el registro se validara o mostrara el resumen del DX
Servicio de gestión de orden de servicio
edicion de datos mecánico
En mecánico motos que están en taller y falta procesos.
Mejorar los criterios y elementos de selección y generación del estado. 
Manejar alerts en la gestion de erroes
BD por tenants 
