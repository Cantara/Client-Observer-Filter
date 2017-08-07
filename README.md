# Client-Observer-Filter
Identifiy which client that are using your api. Observe cookie id, client ip and browser type.

Includin this library into your api you will be able to observe your users individual behaviours.

## Integration

In pom.xml
``` 
<dependency>
  <groupId>no.cantara.observer</groupId>
  <artifactId>client-observer-filter</artifactId>
  <version>0.1-SNAPSHOT</version>
</dependency>
```

### Dropwizard
```
environment.servlets().addFilter("ClientObserverFilter", new ClientObserverFilter())
  .addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

```

## Reporting

TODO - Look for reporting.cantara.io maybe?

### Logs

#### Dropwizard 
``` 
logging:
  level: INFO
  ...
  loggers:
    ....
    "ClientObserverFilter":
      level: TRACE
      additive: false
      appenders:
        - type: file
          currentLogFilename: log/client-observer-filter.log
          archivedLogFilenamePattern: log/client-observer-filter-%d.log.gz
          archivedFileCount: 20
```