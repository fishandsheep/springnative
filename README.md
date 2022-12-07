# springnative
# springnative
1. 默认native打包，默认使用 `glibc`
```
./mvnw -Pnative native:compile
```
2. 尽可能的 `static` ,只支持 `glibc`
```
./mvnw -Pnative native:compile -DbuildArgs=-H:+StaticExecutableWithDynamicLibC
```
3. 使用 `musl` 编译
```
./mvnw -Pnative native:compile -DbuildArgs=libc=musl
```
4. 编译为完全 `static`，仅仅支持 `musl`
```
./mvnw -Pnative native:compile -DbuildArgs=libc=musl,--static
```
