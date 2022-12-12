# ASCII Art

[![pipeline status](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart/badges/master/pipeline.svg)](https://gitlab.fit.cvut.cz/BI-OOP/B201/asciiart)

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them. (https://courses.fit.cvut.cz/BI-OOP/projects/ASCII-art.html)

App supports commands:

--image "path to image"

--image-random

--output-console

--output-file "path to file"

--table "name of table" (Supported names: "non-linear", "Paul Bourkes’ table". Default table is "Paul Bourkes’ table")

--custom-table "content of table"

--invert

--rotate value (Value may be: +90,-90, 180, 360, -270...)

--brightness value (Value is a number.)