package dev.bug.logging.starter.autoconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@EnableConfigurationProperties(LoggingProperties.class)
@ConditionalOnProperty(value = "demo.logging.enabled", havingValue = "true", matchIfMissing = true)
public class LoggingAutoConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public CommonsRequestLoggingFilter requestLoggingFilter(LoggingProperties properties) {
        var loggingFilter = new CommonsRequestLoggingFilter();
        loggingFilter.setBeforeMessagePrefix(properties.getMessagePrefix());
        loggingFilter.setAfterMessagePrefix(properties.getMessagePrefix());
        loggingFilter.setBeforeMessageSuffix("");
        loggingFilter.setAfterMessageSuffix("");
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(properties.getPayload().getMaxLength());
        LOG.info("Using following configurations: 'message prefix' - {}, 'max payload length' - {}",
                properties.getMessagePrefix(), properties.getPayload().getMaxLength());
        return loggingFilter;
    }
}
