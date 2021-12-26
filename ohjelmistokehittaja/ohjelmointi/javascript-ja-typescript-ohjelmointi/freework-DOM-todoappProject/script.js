// UI vars 

const form = document.querySelector('form');
const input = document.querySelector('#txtTaskName');
const btnDeleteAll = document.querySelector('#btnDeleteAll');
const taskList = document.querySelector('#task-list');
let items;

// load items
loadItems();

// call event listeners
eventListeners();

function eventListeners() {
    // submit event
    form.addEventListener('submit', addNewItem);

    // delete an item
    taskList.addEventListener('click', deleteItem);

    // delete all items
    btnDeleteAll.addEventListener('click', deleteAllItems);
}

function loadItems() {

    items = getItemsFromLocalStorage();
    items.forEach(function (item) {
        createItem(item);
    })
}

// get Items From local storage
function getItemsFromLocalStorage() {
    if(localStorage.getItem('items') === null) {
        items = [];
    
    } else {
        items = JSON.parse(localStorage.getItem('items'));
    }
    return items;
}

// set Items to local storage
function setItemToLocalStorage(text) {
    items = getItemsFromLocalStorage();
    items.push(text);
    localStorage.setItem('items', JSON.stringify(items));

}

// delete item from local storage
function deleteItemFromLocalStorage(text) {
    items = getItemsFromLocalStorage();
    items.forEach(function(item, index){
        if(item === text){
            items.splice(index,1);
        }
    });
    localStorage.setItem('items', JSON.stringify(items));
}

function createItem(text) {
    // create li
    const li = document.createElement('li');
    li.className = 'list-group-item list-group-item-secondary';
    li.appendChild(document.createTextNode(text));

    // create a
    const a = document.createElement('a');
    a.classList = 'delete-item float-end';
    a.setAttribute('href', '#');
    a.innerHTML = '<i class="fas fa-times"></i>';

    // add a to li
    li.appendChild(a);

    // add li to ul
    taskList.appendChild(li);

}

// add new item
function addNewItem(e) {
    if (input.value === '') {
        alert('add new item');
    }

    // create item
    createItem(input.value);

    //save to local storage
    setItemToLocalStorage(input.value);

    // clear input
    input.value = '';

    e.preventDefault();

}

// delete an item
function deleteItem(e) {
    if (e.target.className === 'fas fa-times') {
        if (confirm('are you sure ?')) {
            e.target.parentElement.parentElement.remove();

            //delete item from local storage
            deleteItemFromLocalStorage(e.target.parentElement.parentElement.textContent); 
        }
    }
    e.preventDefault();
}

// delete all items
function deleteAllItems(e) {

    if (confirm('are you sure ?')) {
        // taskList.innerHTML='';
        while(taskList.firstChild) {
            taskList.removeChild(taskList.firstChild);
        }
        localStorage.clear();
    }
    e.preventDefault();
}
