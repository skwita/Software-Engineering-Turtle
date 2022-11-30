![badge](https://github.com/skwita/Software-Engineering-Turtle/actions/workflows/maven.yml/badge.svg)
# Software-Engineering-Turtle
*Study project "Turtle" for software engineering*
# Overview
This is a small service that allows you to transform text instructions into a picture.

Input should be provided into http get request body like:
`{"input":"INSTRUCTIONS"}`, where `INSTRUCTIONS` is the place for your input string.

The resulting image will be saved with the path that is provided in the response body.

### The set of instructions is shown in the table below
| Instruction | Description                               |
|-------------|-------------------------------------------|
| \>          | Moves turtle one tile to the right        |
| <           | Moves turtle one tile to the left         |
| ^           | Moves turtle one tile up                  |
| V           | Moves turtle one tile down                |
| +           | After this turtle will leave trail        |
| -           | After this turtle will stop leaving trail |
| R           | Changes trail color to red                |
| G           | Changes trail color to green              |
| B           | Changes trail color to blue               |

# Examples of usage
input in the request body:

`
{"input":"->>>>>>>>>>>>>>>VVVVVVVVVVVVVVV->>>>>>>>>>>>+B>>>>>>>-V+>>>-V+>>-V+>-V+>>-V+>V-V+>-V+>V->+VVV->+VVVVVVV-<+VVV-<+VV-<+V-<+VV-V+<<-<+V-V+<<-V+<<<-V+<<<<<<<-^+<<<-^+<<-^+<-^+<<-<+^^-<+^-<+^^-<+^^^-<+^^^^^^^->+^^^->+^^->+^->+^^-^+>>->+^-^+>>-^+>>>-VVVVVVVVR+V<<V<VV>V>>^>^^<<V<>V^>-^^^>>>>>>>>>>+V<<V<VV>V>>^>^^<<V<>V^>->>>>VVVVVVVVG+V-V+<-V+<<-V+<<<-V+<<<<<<<-^+<<<-^+<<-^+<-^+<-"}
`

output saved on the machine:

![output example #1](https://github.com/skwita/Software-Engineering-Turtle/blob/0e9b12c5f54565842aba8897edff45190e49e38d/outputExamples/image1.jpg)

input in the request body:

`
{"input":"->+RVVVVV^^>>^^VVVV->>+>><<^^>><<^^>>->+>VVVV>>->^^^^+>VVVV>>->+>>>^^^^<<VVVV>>->>>>>>+^^^^-VVVV+>->+^^^^VVV-V+>->+^^^^->>+>>VVVV<<^^^^->>>+>><VV>>^V<<V><V->+>->+>>><<^^^^->>>+>><VVVV>->+^^^"}
`

output saved on the machine:

![output example #2](https://github.com/skwita/Software-Engineering-Turtle/blob/0e9b12c5f54565842aba8897edff45190e49e38d/outputExamples/image2.jpg)
