INSERT IGNORE INTO payment (id, amount, card_holder_name, card_number, card_expiration, card_verification_code, status) values
    (1, 51.8, 'ANDERSON DA SILVA', '1111 2222 3333 4444', '2022-07', '123', 'CREATED'),
    (2, 3000.0, 'CAROLINE SOUZA', '1234 1234 1234 1234', '2023-06', '234', 'CREATED'),
    (3, 200.0, 'MARIA SILVA', '1111 1111 1111 1111', '2024-05', '456', 'CONFIRMED'),
    (4, 400.0, 'JOÃO QUEIROZ', '2222 3333 2222 4444', '2025-04', '567', 'CANCELED');
