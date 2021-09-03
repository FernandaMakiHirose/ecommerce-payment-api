# Criando uma solução de e-commerce com microsserviços em Java - Backend - Payment
Neste projeto desenvolvi o backend de uma solução de e-commerce com a arquitetura de microsserviços, a qual apliquei a integração entre eles orientada a eventos com Apache Kafka e garanti a compatibilidade entre da comunicação dos microsserviços com Schema Registry. Para isso, programei em Java utilizando a stack do Spring (Spring Boot, Spring Cloud Streams).

## Requisitos
- Java
- Docker
- IDE

## Licença
Distribuido sob a licença MIT License. Veja `LICENSE` para mais informações.

## Acesse as outras partes do projeto
- [Checkout](https://github.com/FernandaMakiHirose/ecommerce-checkout-api)
- [Frontend](https://github.com/FernandaMakiHirose/ecommerce-checkout-frontend)

## Docker Compose
Se você navegar na pasta do Docker Compose e digitar o comando `docker-compose` você abra a lista de comandos dele.

Para subir: 
>docker-compose up --build -d

Ver todos os containers que estão rodando:
>docker ps
