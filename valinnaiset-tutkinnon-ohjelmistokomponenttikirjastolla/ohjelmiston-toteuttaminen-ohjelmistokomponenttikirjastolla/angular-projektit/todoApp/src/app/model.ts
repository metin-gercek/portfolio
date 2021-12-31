export class Model {
    user;
    items;
    constructor() {
        this.user = "Metin";
        this.items = [
            new TodoItem("Sport", true),
            new TodoItem("Breakfast", false),
            new TodoItem("Reading", false),
            new TodoItem("Cinema", false),

        ]
    }
}

export class TodoItem {
    description: any;
    action: any;

    constructor(description: any, action: any) {
        this.description = description;
        this.action = action;
    }
}