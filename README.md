# java-cli-pbpu

## Ideas
- Restaurant Cashier System<br>
  class:
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
  - Logger extend Record
    - getRecord
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
