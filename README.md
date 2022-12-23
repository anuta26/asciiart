# ASCII Art

The idea of this project is to load images, translate them into ASCII ART images, optionally apply filters, and save them.

### App supports commands:

Inputs:

    --image "path to image"

    --image-random

Outputs:

    --output-console

    --output-file "path to file"

Conversion tables:

    --table "name of table" (Supported names: "non-linear", "Paul Bourkes’ table". Default table is "Paul Bourkes’ table")

    --custom-table "content of table"

Filters:

    --invert

    --rotate value (Value may be: +90,-90, 180, 360, -270...)

    --brightness value (Value is a number.)
