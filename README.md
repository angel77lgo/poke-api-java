# API Pokemon SOAP

Este es un pequeño proyecto en Java que realiza una consulta al API de Pokemon, para convertir el API REST en una respuesta SOAP, además guarda la ip, la hora de la petición en una base datos en PostgresSQL.

## Inicar el proyecto

Para poder inicar el proyecto es necesario contar con Docker instalado, despues ejecutar el comando:

```bash
docker-compose up
```

## Configurar SonarQube

Este comando a su vez lanza una instancia de SonarQube.

Para poder acceder a la instancia es en: [SonarQube](http://localhost:9000), una vez configurado para ejecutar el analisis de codigo hay que ejecutar el siguiente comando:

```bash
mvn clean verify sonar:sonar -Dsonar.projectKey=myProject -Dsonar.host.url=http://localhost:9000 -Dsonar.login=<token>
```

## Consumor Servicios

Obtener Pokemon por nombre:

```bash
curl --location 'http://localhost:8080/ws' \
--header 'Content-Type: text/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://example.com/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:GetPokemonRequestName>
         <name>vulpix</name>
      </pok:GetPokemonRequestName>
   </soapenv:Body>
</soapenv:Envelope>'
```

Obtener Pokemon por Id:

```bash
curl --location 'http://localhost:8080/ws' \
--header 'Content-Type: text/xml' \
--data '<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:pok="http://example.com/pokemon">
   <soapenv:Header/>
   <soapenv:Body>
      <pok:GetPokemonRequestName>
         <name>vulpix</name>
      </pok:GetPokemonRequestName>
   </soapenv:Body>
</soapenv:Envelope>'
```