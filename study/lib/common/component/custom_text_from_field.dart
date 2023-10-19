import 'package:flutter/material.dart';
import 'package:study/common/const/colors.dart';
class CustomTextFromField extends StatelessWidget {
  final String? hintText;
  final String? errorText;

  const CustomTextFromField({
    this.hintText,
    this.errorText,
    Key? key,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      cursorColor: PRIMARY_COLOR,
      decoration: InputDecoration(
        contentPadding: EdgeInsets.all(20),
        hintText: hintText,
        errorText: errorText,
      ),
    );
  }
}

