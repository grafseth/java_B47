package ru.gs.addressbook.model;

public record GroupData(String Id, String name, String header, String footer) {

    public GroupData() {
        this("", "", "", "");
    }

    public GroupData withName(String name) {
        return new GroupData(this.Id, name, this.header, this.footer);
    }

    public GroupData withId(String id) {
        return new GroupData(id, this.name, this.header, this.footer);
    }
    public GroupData withHeader(String header) {
        return new GroupData(this.Id, this.name, header, this.footer);
    }
    public GroupData withFooter(String footer) {
        return new GroupData(this.Id, this.name, this.header, footer);
    }
}