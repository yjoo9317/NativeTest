
attribute vec4 vertexPosition;
attribute vec4 vertexColor;
varying vec4 fragmentColor; // to fragment shader

void main() {
    //gl_Position.xyz = vertexPosition;
    //gl_Position.w = 1.0;
    gl_Position = vertexPosition;
    fragmentColor = vertexColor;
}
