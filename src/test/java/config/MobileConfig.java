package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
    "classpath:config/${environment}.properties"})
public interface MobileConfig extends Config {

  @Key("browserstack.device")
  String device();

  @Key("browserstack.os")
  String os();

  @Key("browserstack.app.url")
  String appUrl();
}
