package cy.com.netu.cynotify.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Locale;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.util.Map;

/**
 * @author christoforosl
 */
@Builder
@NoArgsConstructor(force = true)
public class CreateMessageRequest {

    @Getter @Setter
    private String relatedRecordType;

    @Getter @Setter
    private Long relatedRecordId;

    @Getter @Setter
    private String destination;

    @Getter @Setter
    private Long templateId;

    @Getter @Setter
    private Locale locale;

    @Getter @Setter
    private Map<String, Object> templateParameters;

    @Getter @Setter
    private Map<String, Object> templateData;

    @Getter @Setter
    private EnumNotificationChannel messageChannel;

    @SuppressWarnings("checkstyle:ParameterNumber")
    @JsonCreator
    public CreateMessageRequest(
            @JsonProperty("relatedRecordType") String relatedRecordType,
            @JsonProperty("relatedRecordId") Long relatedRecordId,
            @JsonProperty("destination") String destination,
            @JsonProperty("templateId") Long templateId,
            @JsonProperty("locale") Locale locale,
            @JsonProperty("templateParameters") Map<String, Object> templateParameters,
            @JsonProperty("templateData") Map<String, Object> templateData,
            @JsonProperty("messageChannel") EnumNotificationChannel messageChannel) {

        this.relatedRecordId = relatedRecordId;
        this.destination = destination;
        this.templateId = templateId;
        this.relatedRecordType = relatedRecordType;
        this.templateData = templateData;
        this.messageChannel = messageChannel;
        this.locale = locale;
        this.templateParameters = templateParameters;
    }

    /**
     * This is for the case where messages are not locale specific
     * @param relatedRecordType The type of the srecord that the message is related to
     * @param relatedRecordId The id of the record that the message is related to
     * @param destination Emails or Mobile number
     * @param templateId The template id, from table notification_template
     * @param messageChannel The channel to send the message, Email or SMS
     */
    public CreateMessageRequest(
            String relatedRecordType,
            Long relatedRecordId,
            String destination,
            Long templateId,
            Map<String, Object> templateParameters,
            EnumNotificationChannel messageChannel) {

        this.relatedRecordId = relatedRecordId;
        this.destination = destination;
        this.templateId = templateId;
        this.relatedRecordType = relatedRecordType;
        this.templateParameters = templateParameters;
        this.templateData = new HashMap<>();
        this.messageChannel = messageChannel;
        this.locale = new Locale("el", "GR"); // default to greek!

    }

    public CreateMessageRequest addTemplateData(String key, Object value) {
        if (this.templateData == null) {
            this.templateData = new HashMap<>();
        }
        this.templateData.put(key, value);
        return this;
    }

}
