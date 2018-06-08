attribute vec3 vertexPosition;
attribute vec3 vertexColor;
varying vec3 fragmentColor; // sent to fragment shader for blending
uniform mat4 mvpMat; // MVP Matrix

void main() {
    gl_Position = mvpMat * vec4(vertexPosition, 1.0);
    fragmentColor = vertexColor;
}
