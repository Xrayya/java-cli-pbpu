# java-cli-pbpu

## Use Case
- Actor: Customer, Cashier, Manager
- Use Cases:
  - Customer:
    - Order
    - Get struct
    - Pay
    - Get change
  - Cashier:
    - Write Order
    - Print struct
    - Give change
    - Make Record
  - Manager:
    - Write Order
    - Print struct
    - Give change
    - Make Record
    - Add Menu

## Ideas
- Restaurant Cashier System<br>
  class:
  - Employee:
    - emloyeeId = UUID
    - name: String
    - username: String
    - password: String
  - Cashier extend User
  - Manager extend User
  - Menu
    - menuId: UUID
    - namaMenu: String
    - category: FoodCategory
    - price: int
  - MenuOrder:
    - menu: Menu
    - quantity: int
  - Order:
    - orderId: UUID
    - menuOrders: MenuOrder[]
    - tableNumber: int
    - getTotalPrice(): int
  - Record:
    - recordFile: File
    - readRecord: 
  - Log extend Record
    - writeRecord
  - CashierApp
    - recordManager = RecordManager
    - printMenus: void
    - addOrder(): bool
    - removeOrder(): bool
    - editOrder: bool
    - printStruct(): void
    - saveToRecord(): bool
  
- To-Do List
- Bookshelf applicatio
