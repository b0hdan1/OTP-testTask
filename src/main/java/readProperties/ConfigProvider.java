package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    static Config readConfig() {
        return ConfigFactory.load("application.conf");
    }

    String LOGIN = readConfig().getString("usersParams.admin.login");
    String PASSWORD = readConfig().getString("usersParams.admin.password");
    Boolean IS_ADMIN = readConfig().getBoolean("usersParams.admin.isAdmin");
}
