//
// Created by Youngjoo Park on 6/6/18.
//

#include "MyCamera.h"
#include "myLogger.h"
#include "math.h"

MyCamera::MyCamera(float fov, float zPosit, float near, float far) {
    glm::vec3 cameraPosition = glm::vec3(0, 0, zPosit);

    viewMatrix = glm::lookAt(cameraPosition,/* eye */ glm::vec3(0, 0, -1), /* pointing up */glm::vec3(0, 1, 0));
    this->nearPlane = near;
    this->farPlane = far;
    this->fov = fov;

    deltaX = deltaY = deltaZ = 0;
    modelQuaternion = glm::quat(glm::vec3(0,0,0));

}