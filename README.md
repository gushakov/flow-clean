# Hello World! Vaadin Flow application with Clean Architecture

"Hello World!" application with Spring Boot and Vaadin Flow using Clean DDD
approach.

- Separates Controller from Presenter.
- Uses separate objects for a (Flow) view and a view-model.
- Use case drives business logic.

There
is [an article](https://medium.com/unil-ci-software-engineering/clean-architecture-application-with-vaadin-flow-896c9aa96a52)
on Medium which references this application.

## Running

Run Maven `package` once before launching (from IDE). This will instruct Vaadin to build necessary
frontend files. This needed because Vaadin dev-server is not enabled for this project.