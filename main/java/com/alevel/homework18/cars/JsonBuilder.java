package com.alevel.homework18.cars;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class JsonBuilder {

    private String indent = "\t";

    void createJsonFile(File file, Map<String, Object> map) {
        try (FileWriter writer = new FileWriter(file)) {
            startWrite(writer);
            writeContent(map, writer, indent);
            endWrite(writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void writeContent(Map<String, Object> map, FileWriter writer, String indent) throws IOException {
        int iteration = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            StringBuilder row = new StringBuilder();
            StringBuilder key = getFormattedValue(entry.getKey());
            if (entry.getValue() instanceof Map) {
                writer.write(indent + key + ": {\n");
                writeContent((Map<String, Object>) entry.getValue(), writer, indent + indent);
                writer.append(indent).append("}");
            } else {
                StringBuilder value = getFormattedValue(entry.getValue());
                row.append(indent).append(key).append(": ").append(value);
                writer.write(String.valueOf(row));
            }
            iteration++;
            if (iteration < map.size()) {
                writer.append(",\n");
            } else {
                writer.append("\n");
            }
        }
    }

    private StringBuilder getFormattedValue(Object value) {
        StringBuilder stringBuilder = new StringBuilder();
        if (value.getClass().isArray()) {
            String[] array = (String[]) value;
            stringBuilder.append("[");
            for (int i = 0; i < array.length; i++) {
                stringBuilder.append("\"").append(array[i]).append("\"");
                if (i < array.length - 1) {
                    stringBuilder.append(",");
                }
            }
            stringBuilder.append("]");
        } else if (value instanceof Integer || value instanceof Double) {
            stringBuilder.append(value);
        } else {
            stringBuilder.append("\"").append(value).append("\"");
        }
        return stringBuilder;
    }

    private void startWrite(FileWriter writer) throws IOException {
        writer.write("{\n");
    }

    private void endWrite(FileWriter writer) throws IOException {
        writer.write("}");
    }

    private boolean isMap(Object object) {
        return object instanceof Map;
    }
}
