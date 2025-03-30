# Compose 导航封装

### 导航
```kotlin
Router.to(TwoDestination)
```

### 清除回收站
```kotlin
Router.offAllTo(OneDestination)
```


### 返回

```kotlin
Router.back()
```

### 替换当前页面

```kotlin
Router.replace(ThreeDestination("replace来自Two"))
```

### 带数据返回

```kotlin
val bundle = Bundle().apply {
	putString("result", "Two Screen Back Result Data")
}
Router.backWithResult(result = bundle)


val result =  appState?.getBackResult()
	LaunchedEffect(result) {
		if (result != null) {
		viewModel.result.value = result.getString("result")
		println("A 页面收到数据: $result")
	}
}

```