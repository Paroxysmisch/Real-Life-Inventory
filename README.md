# 3D File System

## Known Issues
These are issues with the implementation in minecraft. Given more time, we would have implemented this from scratch in C++ with OpenGL/DirectX and avoided these issues.
* Blocks cannot be placed beneath or on top a document block due to the use of an invisible armour stand.
* If the player's inventory is full, the document block is lost if it is broken.
* Document blocks do not save and reload correctly.

## Potential Features
Without the limitations of minecraft and the amount of time we had, there are a few features we would have liked to include.
* A procedurally generated world with placeable file entities specifically designed to ease navigation and so that different areas were visually distinct.
* Quick navigation through the world to ensure that the 3D file system can be as fast and efficient as a 2D filesystem.
* A much more light-weight application so that it can be opened quickly.
