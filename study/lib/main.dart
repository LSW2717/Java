import 'package:flutter/material.dart';
import 'package:study/common/component/custom_text_from_field.dart';

void main() {
  runApp(
      _App()
  );
}
class _App extends StatelessWidget {
  //상속을 받았고 아래것은 생성자다 
  const _App({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            CustomTextFromField(
              hintText: '이메일을 입력해주세요',
              errorText: '에러가 났습니다',
            ),
          ],
        ),
      ),
    );
  }
}
