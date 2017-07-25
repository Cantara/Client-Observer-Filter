# Client-Observer-Filter
Identifiy which client that are using your api. Observe cookie id, client ip and browser type.

Includin this library into your api you will be able to observe your users individual behaviours.

## Integration

### Dropwizard
```
environment.servlets().addFilter("/*", new ClientObserverFilter());

```

## Reporting

TODO - Look for reporting.cantara.io maybe?

### Logs
