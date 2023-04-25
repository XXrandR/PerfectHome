package com.jhosuadaga.abstracthome.WidgetObject;

public class WidgetObject {
    private String name;
    private int icon;
    private int row;
    private int column;
    private int rowSpan;
    private int columnSpan;
    private int color;

    public WidgetObject(String name, int icon, int row, int column, int rowSpan, int columnSpan, int color) {
        this.name = name;
        this.icon = icon;
        this.row = row;
        this.column = column;
        this.rowSpan = rowSpan;
        this.columnSpan = columnSpan;
        this.color = color;
    }

    public WidgetObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    public int getColumnSpan() {
        return columnSpan;
    }

    public void setColumnSpan(int columnSpan) {
        this.columnSpan = columnSpan;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
