# Simulation - Симуляция

Принцип игры
----------

Пошаговая симуляция 2D мира, населённого травоядными и хищниками. Кроме существ, мир содержит ресурсы (траву), которыми питаются травоядные, и статичные объекты (горы, деревья), с которыми нельзя взаимодействовать - они просто занимают место.

2D мир представляет из себя матрицу NxM, каждое существо или объект занимают клетку целиком, нахождение в клетке нескольких объектов/существ - недопустимо.

![image](https://github.com/KittyNicky/Simulation/assets/133746035/90cfc353-c6f4-414b-abc2-1d77adf5f2bd)

- Действия существ:  
_Herbivore_: Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение.  
_Predator_: Стремится найти травоядное, может потрать свой на движение в сторону травоядного, либо на атаку травоядного. При этом количество HP травоядного уменьшается на силу атаки хищника. Если значение HP жертвы опускается до 0, травоядное исчезает.

- Движение существ осуществляется с помощью алгоритма "Поиск в ширину"
