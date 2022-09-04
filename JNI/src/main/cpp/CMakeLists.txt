# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
#声明版本
cmake_minimum_required(VERSION 3.10.2)

# Declares and names the project.

project("mypracticedemo")

#音频渲染
set(OpenSL ${CMAKE_SOURCE_DIR}/opensl)
#视频渲染
set(OpenGL ${CMAKE_SOURCE_DIR}/gles)

#定义 ffmpeg、rtmp 、yk_player 目录
set(FFMPEG ${CMAKE_SOURCE_DIR}/ffmpeg)
set(RTMP ${CMAKE_SOURCE_DIR}/librtmp)
set(YK_PLAYER ${CMAKE_SOURCE_DIR}/player)


#指定 ffmpeg 头文件目录
include_directories(${FFMPEG}/include)

#指定 ffmpeg 静态库文件目录
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${FFMPEG}/libs/${CMAKE_ANDROID_ARCH_ABI}")

#指定 rtmp 静态库文件目录
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${RTMP}/libs/${CMAKE_ANDROID_ARCH_ABI}")

#批量添加自己编写的 cpp 文件,不要把 *.h 加入进来了
file(GLOB ALL_PLAYER_CPP ${YK_PLAYER}/*.cpp)

#批量添加自己编写的 cpp 文件,不要把 *.h 加入进来了
file(GLOB ALL_CPP ${OpenSL}/*.cpp ${OpenGL}/*.cpp)


# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
        native-lib.cpp)

add_library(audiovideo SHARED ${ALL_CPP})

#添加自己编写 cpp 源文件生成动态库
add_library(YK_PLAYER SHARED ${ALL_PLAYER_CPP})

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )

#最后才开始链接库
target_link_libraries(
        YK_PLAYER
        # 写了此命令不用在乎添加 ffmpeg lib 顺序问题导致应用崩溃
        -Wl,--start-group
        avcodec avfilter avformat avutil swresample swscale
        -Wl,--end-group
        z
        rtmp
        android
        #音频播放
        OpenSLES
        ${log_lib}
)


