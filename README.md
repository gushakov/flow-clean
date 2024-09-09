# Hello World! Vaadin Flow application with Clean Architecture

"Hello World!" application with Spring Boot and Vaadin Flow using Clean DDD
approach.

- Separates Controller from Presenter.
- Uses separate objects for a (Flow) view and a view-model.
- Use case drives business logic.

## Running

Run Maven `package` once before launching (from IDE). This will instruct Vaadin to build necessary
frontend files. This needed because Vaadin dev-server is not enabled for this project.