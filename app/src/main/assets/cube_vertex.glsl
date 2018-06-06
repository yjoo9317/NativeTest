#version 120

attribute vec4 vertexPosition;
attribute vec4 vertexColor;
varying vec4 fragmentColor; // sent to fragment shader for blending
uniform mat4 mvpMat; // MVP Matrix

void main() {
    gl_Position = mvpMat * vertexPosition;
    fragmentColor = vertexColor;
}
