# spring-boot-db-init-with-jpa-entity-manager
Example of initializing database as part of the spring boot application startup.

This particular example deals with the fact that you cannot use an EntityManager
in a @PostConstruct method. Instead it does the initialization in an ApplicationReadyEvent
handler.
