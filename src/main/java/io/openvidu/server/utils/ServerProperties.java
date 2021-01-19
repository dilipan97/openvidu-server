package io.openvidu.server.utils;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

public class ServerProperties {
    private String rtspUri;
    private String type;
    private String data;
    private Integer port;

    ServerProperties(String rtspUri, String type, String data, Integer port) {
        this.rtspUri = rtspUri;
        this.type = type;
        this.data = data;
        this.port = port;
    }

    public String getRtspUri() {
        return rtspUri;
    }

    public void setRtspUri(String rtspUri) {
        this.rtspUri = rtspUri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public JsonObject toJson(String sessionId) {
        JsonObject json = new JsonObject();
        json.addProperty("session", sessionId);

        if (this.getRtspUri() != null) {
            json.addProperty("rtspUri", this.getRtspUri());
        } else {
            json.add("rtspUri", JsonNull.INSTANCE);
        }

        if (this.getType() != null) {
            json.addProperty("type", this.getType());
        } else {
            json.add("type", JsonNull.INSTANCE);
        }

        if (this.getData() != null) {
            json.addProperty("data", this.getData());
        } else {
            json.add("data", JsonNull.INSTANCE);
        }

        if (this.getPort() != null) {
            json.addProperty("port", this.getPort());
        } else {
            json.add("port", JsonNull.INSTANCE);
        }

        return json;
    }

    public static class Builder {
        private String rtspUri;
        private String type;
        private String data;
        private Integer port;

        public Builder() {
        }

        public ServerProperties build() {
            return new ServerProperties(this.rtspUri, this.type, this.data, this.port);
        }

        public ServerProperties.Builder rtspUri(String rtspUri) {
            this.rtspUri = rtspUri;
            return this;
        }

        public ServerProperties.Builder type(String type) {
            this.type = type;
            return this;
        }

        public ServerProperties.Builder data(String data) {
            this.data = data;
            return this;
        }

        public ServerProperties.Builder port(Integer port) {
            this.port = port;
            return this;
        }
    }
}
